package com.himedia;

import com.himedia.domain.posts.Posts;
import com.himedia.domain.posts.PostsRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After("") //테스트한 후에 할 거
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){

        //given
        String title="테스트 게시글";
        String content="테스트 본문";

        //테이블 posts에 insert/update 쿼리를 실행, id값이 있으면 update가, 없다면 insert 쿼리 실행
        postsRepository.save(Posts.builder().title(title).content(content).author("hong@gmail.com").build());

        //when
        List<Posts> postsList=postsRepository.findAll(); //모든 데이터를 조회

        //then
        Posts posts=postsList.get(0);

//        System.out.println(">>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());


        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);


    }

}

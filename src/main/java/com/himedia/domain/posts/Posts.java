package com.himedia.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //Entity클래스에서는 절대 Setter 메소드를 만들지 않는다. 대신 해당 필드에 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 한다. 빌더 패턴으로 값을 채움
@NoArgsConstructor  //기본 생성자 자동 추가(lombok)
@Entity
public class Posts {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 500, nullable = false)     //해당 클래스의 필드는 모두 칼럼이 되지만 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


    private String author;

    @Builder    //해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함된다.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

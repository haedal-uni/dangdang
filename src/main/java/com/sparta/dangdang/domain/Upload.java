package com.sparta.dangdang.domain;

import com.sparta.dangdang.dto.UploadDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Upload extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String file;

    public Upload(UploadDto uploadDto) {
        this.content = uploadDto.getContent();
        this.file = uploadDto.getFile();
    }
}

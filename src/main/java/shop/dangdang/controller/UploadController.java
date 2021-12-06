package shop.dangdang.controller;

import shop.dangdang.domain.Membership;
import shop.dangdang.domain.Upload;
import shop.dangdang.dto.UploadDto;
import shop.dangdang.service.MembershipService;
import shop.dangdang.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shop.dangdang.service.S3Uploader;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UploadController {
    private final UploadService uploadService;
    private final MembershipService membershipService;

    @PostMapping("/api/upload") //@RequestParam이 여러개 있다. -> @ModelAttribute
    public Upload setUpload(@ModelAttribute UploadDto uploadDto) throws IOException{
        System.out.println(uploadDto.getImage().getOriginalFilename());
        return uploadService.setUpload(uploadDto);
    }

    // 테스트(1개만 갖고 오기)
    @GetMapping("/test")
    public Upload doTest(@RequestParam Long idx) {
        return uploadService.doTest(idx);
    }

    // 테스트2(리스트 전체 가져오기)
    @GetMapping("/test2")
    public List<Upload> doTest2() {
        return uploadService.doTest2();
    }

    //회원가입할 때 정보 가져오기
    @GetMapping("/api/membership")
    public List<Membership> puppy() {
        return membershipService.puppy();
    }
}



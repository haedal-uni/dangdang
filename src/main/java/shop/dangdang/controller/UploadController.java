package shop.dangdang.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shop.dangdang.domain.Membership;
import shop.dangdang.domain.Upload;
import shop.dangdang.dto.UploadDto;
import shop.dangdang.service.MembershipService;
import shop.dangdang.service.UploadService;

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

    // 사진 정보 main 페이지로 가져오기(전체)
    @GetMapping("/maininfo")
    public List<Upload> getmaininfo() {
        return uploadService.getmaininfo();
    }

    // 사진들 photo 페이지로 가져오기(전체) 주소 비교
    @GetMapping("/photos/{addressId}")
    public List<Upload> getphotos(@PathVariable("addressId") Long addressId) {
        return uploadService.getphotos(addressId);
    }

    //회원가입할 때 정보 가져오기
    @GetMapping("/api/membership")
    public List<Membership> puppy() {
        return membershipService.puppy();
    }
}



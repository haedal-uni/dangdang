package shop.dangdang.controller;

import shop.dangdang.domain.Membership;
import shop.dangdang.domain.Registry;
import shop.dangdang.dto.MembershipDto;
import shop.dangdang.dto.RegistryDto;
import shop.dangdang.service.RegistryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RegistryController {
    private final RegistryService registryService;

    @PostMapping("/registry") //@RequestParam이 여러개 있다. -> @ModelAttribute
    public Registry setUpload(@ModelAttribute RegistryDto uploadDto) throws IOException{
        System.out.println(uploadDto.getImage().getOriginalFilename());
        return registryService.setUpload(uploadDto);
    }

    //회원가입할 때 정보 가져오기
    @GetMapping("/registry")
    public Membership getMembership(@RequestBody MembershipDto membershipDto) throws IOException {
        return registryService.getMembership(membershipDto);
    }

    // 사진만 전부 가져오기
    @GetMapping("/photos")
    public List<Registry> photos(){
        return registryService.photos();
    }
}



package shop.dangdang.controller;

import shop.dangdang.domain.Membership;
import shop.dangdang.domain.Registry;
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

    // 테스트(1개만 갖고 오기)
    @GetMapping("/test")
    public Registry doTest(@RequestParam Long idx) {
        return registryService.doTest(idx);
    }

    // 테스트2(리스트 전체 가져오기)
    @GetMapping("/test2")
    public List<Registry> doTest2() {
        return registryService.doTest2();
    }

    //회원가입할 때 정보 가져오기
    @GetMapping("/registryㅁㅁㅁ")
    public List<Membership> puppy() {
        return registryService.puppy();
    }
}



package shop.dangdang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dangdang.domain.Membership;
import shop.dangdang.domain.Registry;
import shop.dangdang.service.MainPageService;

import java.util.List;

@RestController
public class MainPageController {
    private final MainPageService mainPageService;

    public MainPageController(MainPageService mainPageService) {
        this.mainPageService = mainPageService;
    }

    // 사진 정보 main 페이지로 가져오기(전체)
    @GetMapping("/mainpage")
    public List<Registry> getMainInfo() {
        return mainPageService.getMainInfo();
    }

    // 사용자 정보(사진,별명) main 페이지로 가져오기(전체)
    @GetMapping("/mainpage/user")
    public List<Membership> getUserMainInfo() {
        return mainPageService.getUserMainInfo();
    }

}

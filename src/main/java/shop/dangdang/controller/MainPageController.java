package shop.dangdang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dangdang.dto.MainPageDto;
import shop.dangdang.service.MainPageService;

@RestController
public class MainPageController {
    private final MainPageService mainPageService;

    public MainPageController(MainPageService mainPageService) {
        this.mainPageService = mainPageService;
    }

    // 사진 정보 main 페이지로 가져오기(전체)
    @GetMapping("/mainpage")
    public MainPageDto getMainInfo(Long registryIdx) {
        return mainPageService.getMainInfo(registryIdx);
    }

}

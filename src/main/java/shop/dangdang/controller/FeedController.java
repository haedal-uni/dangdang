package shop.dangdang.controller;

import shop.dangdang.domain.Feed;
import shop.dangdang.dto.FeedRequestDto;
import shop.dangdang.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FeedController {

    private final FeedService feedService;

    // Feed 데이터 가져오기
    @GetMapping("/api/main")
    public List<Feed> getAllFeed() {
        return feedService.getAllFeed();
    }

    // Feed 데이터 저장하기
    @PostMapping("/api/Feeds")
    public Feed createFeed(@RequestBody FeedRequestDto requestDto){
        Feed feed = feedService.createFeed(requestDto);
        return feed;
    }

}

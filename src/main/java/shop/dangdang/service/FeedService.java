package shop.dangdang.service;

import shop.dangdang.domain.Feed;
import shop.dangdang.dto.FeedRequestDto;
import shop.dangdang.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedRepository feedRepository;

    // 전체 Feed 상품 조회
    public List<Feed> getAllFeed() {
        return feedRepository.findAll();
    }

    // 등록
    public Feed createFeed(FeedRequestDto requestDto){
        Feed feed = new Feed(requestDto);
        feedRepository.save(feed);
        return feed;
    }
}

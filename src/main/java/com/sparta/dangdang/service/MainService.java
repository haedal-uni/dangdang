package com.sparta.dangdang.service;

import com.sparta.dangdang.domain.Feed;
import com.sparta.dangdang.domain.User;
import com.sparta.dangdang.dto.FeedDto;
import com.sparta.dangdang.repository.FeedRepository;
import com.sparta.dangdang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MainService {
    private final FeedRepository feedRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<Feed> getMain(FeedDto feedDto, User NickName) {
        Feed nickName = new Feed(feedDto, NickName);
        return feedRepository.findAllByNickName(nickName);
    }
}
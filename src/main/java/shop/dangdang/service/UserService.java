package shop.dangdang.service;

import shop.dangdang.domain.User;
import shop.dangdang.dto.UserRequestDto;
import shop.dangdang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 전체 User 상품 조회
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    // 등록
    public User createUser(UserRequestDto requestDto){
        User user = new User(requestDto);
        userRepository.save(user);
        return user;
    }
}

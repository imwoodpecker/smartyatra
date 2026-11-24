package com.smartyatra.smart_yatra_backend.service;

import com.smartyatra.smart_yatra_backend.dto.FavoriteDestinationDto;
import com.smartyatra.smart_yatra_backend.entity.FavoriteDestination;
import com.smartyatra.smart_yatra_backend.entity.User;
import com.smartyatra.smart_yatra_backend.exception.ApiException;
import com.smartyatra.smart_yatra_backend.repository.FavoriteDestinationRepository;
import com.smartyatra.smart_yatra_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteDestinationService {

    private final FavoriteDestinationRepository repository;
    private final UserRepository userRepository;

    public void addFavorite(FavoriteDestinationDto dto, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException("User not found"));

        boolean exists = repository.existsByUserIdAndLatitudeAndLongitude(user.getId(), dto.getLatitude(), dto.getLongitude());
        if (exists) {
            throw new ApiException("Destination already in favorites");
        }

        FavoriteDestination favorite = FavoriteDestination.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .thumbnailUrl(dto.getThumbnailUrl())
                .user(user)
                .build();

        repository.save(favorite);
    }

    public List<FavoriteDestinationDto> getFavorites(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException("User not found"));

        return repository.findByUserId(user.getId()).stream()
                .map(fav -> new FavoriteDestinationDto(
                        fav.getName(),
                        fav.getAddress(),
                        fav.getLatitude(),
                        fav.getLongitude(),
                        fav.getThumbnailUrl()
                ))
                .toList();
    }


    @Transactional
    public void removeFavorite(String email, Double lat, Double lng) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException("User not found"));

        repository.deleteByUserIdAndLatitudeAndLongitude(user.getId(), lat, lng);
    }
}
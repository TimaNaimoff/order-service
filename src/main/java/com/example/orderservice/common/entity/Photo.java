package com.example.orderservice.common.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "photos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ключ в файловом/CDN хранилище
    @Column(nullable = false, unique = true)
    private String photoKey;

    // Ссылка (если генерируешь URL заранее)
    private String url;

    // Опционально — цветовой код для UI
    private String color;

    // Флаг "вертикальная картинка"
    private Boolean hasVerticalPhoto;
}

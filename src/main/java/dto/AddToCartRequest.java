package dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddToCartRequest {
    private Long product_id;
    private Long quantity;
}

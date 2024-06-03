package org.example.shopping.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.shopping.dto.reponse.UserResponse;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseList<T extends Serializable> implements Serializable {
    List<T> user;
    int totalPages;
}

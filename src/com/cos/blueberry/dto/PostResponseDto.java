package com.cos.blueberry.dto;

import com.cos.blueberry.model.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponseDto {
	private Post post;
	private String Username;

}


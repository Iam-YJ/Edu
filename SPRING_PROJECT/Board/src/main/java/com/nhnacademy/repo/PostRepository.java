package com.nhnacademy.repo;

import com.nhnacademy.domain.Post;
import java.util.List;

public interface PostRepository {

    long register(Post post);

    void modify(Post post);

    void remove(long id);

    Post getPostByUserId(String userId);

    Post getPost(long id);

    long getContentIdByUserId(String userId);

    List<Post> getPosts();

    long getSize();
}
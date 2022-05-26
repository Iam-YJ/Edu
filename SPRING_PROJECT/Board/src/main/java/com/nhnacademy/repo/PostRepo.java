package com.nhnacademy.repo;

import com.nhnacademy.domain.Post;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PostRepo implements PostRepository {
    private List<Post> postList = new ArrayList<>();

    @Override
    public long register(Post post) {
        postList.add(post);
        return postList.size();
    }

    @Override
    public void modify(Post post) {
        for (Post originalPost : postList) {
            if (originalPost.getId() == (post.getId())) {
                originalPost.setContent(post.getContent());
                originalPost.setTitle(post.getTitle());
                originalPost.setWriteTime(post.getWriteTime());
            }
        }
    }

    @Override
    public void remove(long id) {
        for(Iterator<Post> iterator = postList.iterator(); iterator.hasNext();){
            Post post = iterator.next();
            if(post.getId() == id){
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public Post getPost(long id) {
        for (Post originalPost : postList) {
            if (originalPost.getId() == (id)) {
                return originalPost;
            }
        }
        return null;
    }

    @Override
    public long getContentIdByUserId(String userId) {
        for (Post originalPost : postList) {
            if (originalPost.getWriterUserId().equals(userId)) {
                return originalPost.getId();
            }
        }
        return 0;
    }

    public Post getPostByUserId(String userId){
        for (Post originalPost : postList) {
            if (originalPost.getWriterUserId().equals(userId)) {
                return originalPost;
            }
        }
        return null;
    }

    @Override
    public List<Post> getPosts() {
        return postList;
    }

    @Override
    public long getSize() {
        return postList.size();
    }
}

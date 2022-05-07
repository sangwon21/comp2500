package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.*;
import academy.pocu.comp2500.assignment1.registry.Registry;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        // write your code here
        String user1 = "Subin";
        String id = "id";

        // 1. 블로그 생성하기
        Blog blog = new Blog(user1);

        assert blog.getPosts().size() == 0;

        Post post1 = new Post(user1, "Test1", "This is test1");

        // 2. 블로그 글 추가하기
        // 3. 블로그 글 목록 가져오기
        blog.addPost(post1);
        blog.addPost(post1);
        assert blog.getPosts().size() == 1;
        assert blog.getPosts().get(0).getTitle().equals("Test1");
        assert blog.getPosts().get(0).getAuthorId().equals("Subin");

        post1.addTag("WSJN");

        String user2 = "Taeyeon";
        Post post2 = new Post(user2, "Test2", "This is test2");
        post2.addTag("SNSD");
        post2.addTag("WSJN");
        blog.addPost(post2);

        // 4. 블로그 글 목록 필터링하기(태그 기준)
        ArrayList<String> tagFilters = new ArrayList<>();
        tagFilters.add("WSJN");
        blog.setTagFilters(tagFilters);
        assert blog.getPosts().size() == 2;
        blog.setSortingType(SortingType.CREATED_AT_DESCENDING);
        assert blog.getPosts().get(0).getTitle().equals("Test2");

        tagFilters.remove("WSJN");
        assert blog.getPosts().size() == 2;

        Post post3 = new Post(user1, "Test3", "This is test3");
        blog.addPost(post3);

        // 5. 블로그 글 목록 필터링하기(작성자 기준)
        blog.setAuthorFilter(user1);
        assert blog.getPosts().size() == 2;

        blog.setAuthorFilter(null);
        tagFilters.remove("WJSN");
        blog.setSortingType(SortingType.CREATED_AT_DESCENDING);

        // 6. 블로그 글 목록 정렬하기
        assert blog.getPosts().get(0).getTitle().equals("Test3");

        blog.setSortingType(SortingType.CREATED_AT_ASCENDING);

        assert blog.getPosts().get(0).getTitle().equals("Test1");

        Comment comment1 = new Comment(user1, "This is comment1");
        post1.addComment(comment1);

        // 7. 블로그 글에 댓글 달기
        assert post1.getComments().size() == 1;
        assert post1.getComments().get(0).getText().equals("This is comment1");

        comment1.addSubcomment(new Comment(user1, "This is subcomment1"));

        // 8. 하위 댓글 달기
        assert comment1.getSubcomments().size() == 1;
        assert comment1.getSubcomments().get(0).getText().equals("This is subcomment1");

        comment1.addUpVoter(user1);
        comment1.addUpVoter(user1);

        // 9. 댓글을 추천/비추천하기
        assert comment1.getUpvoter() == 1;

        comment1.addDownVoter(user1);

        assert comment1.getDownvoter() == 1;
        assert comment1.getUpvoter() == 0;

        // 10. 블로그 글 업데이트하기
        post1.setBody("This has changed", user1);
        assert post1.getBody().equals("This has changed");

        post1.setTitle("Title", user1);
        assert post1.getTitle().equals("Title");

        // 11. 블로그 글에 리액션 달기
        post2.addReaction(Reaction.ANGRY);
        post2.addReaction(Reaction.ANGRY);

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
    }
}

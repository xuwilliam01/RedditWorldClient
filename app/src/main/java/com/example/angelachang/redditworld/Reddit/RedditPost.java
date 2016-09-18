package com.example.angelachang.redditworld.Reddit;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by angelachang on 9/17/16.
 */
public class RedditPost {

    private String m_url;
    ArrayList<Comment> comments;
    private String m_post;
    private String m_author;

    RedditPost(String url){
        m_url = url + ".json";
        comments = fetch();
    }

    public String getUrl(){
        return m_url;
    }
    public String getPost(){
        return m_post;
    }
    public String getAuthor(){
        return m_author;
    }
    /**
     * Returns a list of Post objects after fetching data from
     * Reddit using the JSON API.
     *
     * @return
     */


    public ArrayList<Comment> fetch(){
        ArrayList<Comment> list = new ArrayList<Comment>();

            String raw = Connection.readContents(m_url);

            try {
                JSONObject data = new JSONObject(raw)
                        .getJSONObject("data");
                JSONArray children = data.getJSONArray("children");


                // primary post section
                m_post = children.getJSONObject(0).optString("selftext_html");
                m_author = children.getJSONObject(0).optString("author");

                // comment section data
                for (int i = 1; i < children.length(); i++) {
                    JSONObject current = children.getJSONObject(i)
                            .getJSONObject("data");

                    Comment comment = new Comment(current.optString("body_html"), current.optString("author"), current.optInt("up"),current.optInt("down"));

                    if (comment.getComment() != null)
                        list.add(comment);
                }
            } catch (Exception e) {
                System.out.printf("Post does not exist.");
            }
        return list;
    }
}

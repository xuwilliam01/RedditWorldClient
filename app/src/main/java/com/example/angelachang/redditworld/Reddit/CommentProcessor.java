package com.example.angelachang.redditworld.Reddit;

/**
 * Created by angelachang on 9/17/16.
 */

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class CommentProcessor {
    // This will be the URL of the comments page, suffixed with .json
    private String url;

    CommentProcessor(String u){
        //url=u+".json";
        url = "https://reddit.com/r/uwaterloo/.json";
    }

    // Load various details about the comment
    private Comment loadComment(JSONObject data, int level){
        Comment comment=new Comment();
        try{
            comment.text = data.getString("body_html");
            comment.author = data.getString("author");
            comment.points = (data.getInt("ups")
                    - data.getInt("downs"))
                    + "";
            comment.postedOn = new Date((long)data
                    .getDouble("created_utc"))
                    .toString();
            comment.level=level;
        }catch(Exception e){
            System.out.println("Error, Unable to parse comment : "+e);
        }
        return comment;
    }

    // This is where the comment is actually loaded
    // For each comment, its replies are recursively loaded
    private void process(ArrayList<Comment> comments
            , JSONArray c, int level)
            throws Exception {
        for(int i=0;i<c.length();i++){
            if(c.getJSONObject(i).optString("kind")==null)
                continue;
            if(c.getJSONObject(i).optString("kind").equals("t1")==false)
                continue;
            JSONObject data=c.getJSONObject(i).getJSONObject("data");
            Comment comment=loadComment(data,level);
            if(comment.author!=null) {
                comments.add(comment);
                addReplies(comments,data,level+1);
            }
        }
    }

    // Add replies to the comments
    private void addReplies(ArrayList<Comment> comments,
                            JSONObject parent, int level){
        try{
            if(parent.get("replies").equals("")){
                // This means the comment has no replies
                return;
            }
            JSONArray r=parent.getJSONObject("replies")
                    .getJSONObject("data")
                    .getJSONArray("children");
            process(comments, r, level);
        }catch(Exception e){
            System.out.println("Error, addReplies : "+e);
        }
    }

    // Load the comments as an ArrayList, so that it can be
    // easily passed to the ArrayAdapter
    ArrayList<Comment> fetchComments(){
        ArrayList<Comment> comments=new ArrayList<Comment>();
        try{

            // Fetch the contents of the comments page
            String raw = Connection.readContents(url);
            System.out.println("hello");
            System.out.println(raw);

            System.out.println("hello");
            JSONObject o = new JSONObject(raw);
            System.out.println("hello");
            JSONObject r1 = o.getJSONObject("data");
            JSONArray o1 = r1.getJSONArray("children");

            System.out.println("hello");
            // All comments at this point are at level 0
            // (i.e., they are not replies)
            //process(comments, r, 0);

        }catch(Exception e){
            System.out.println("Error, Could not connect: "+e);
        }
        return comments;
    }
}

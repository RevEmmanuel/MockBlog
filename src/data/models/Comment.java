package data.models;

public class Comment {

    private String commenterName;
    private int id;
    private String comment;

    public Comment() {
    }

    public Comment(int id, String commenterName, String comment) {
        this.commenterName = commenterName;
        this.id = id;
        this.comment = comment;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object obj) {
        Comment comparing = (Comment) obj;
        return this.id == comparing.getId() && this.commenterName.equals(comparing.getCommenterName()) && this.comment.equals(comparing.getComment());
    }
}

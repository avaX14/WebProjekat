package model;

public class Comment {
	
	private Integer snippetId;
	private Integer commentId;
	private String tekst;
	private String datum;
	private String userId;
	private Rating rating;
	
	public Comment(){
		
	}

	public Comment(Integer snippetId, Integer commentId, String tekst, String datum, String userId,
			Rating rating) {
		super();
		this.snippetId = snippetId;
		this.tekst = tekst;
		this.datum = datum;
		this.userId = userId;
		this.rating = rating;
		this.commentId = commentId;
	}

	public Integer getSnippetId() {
		return snippetId;
	}

	public void setSnippetId(Integer snippetId) {
		this.snippetId = snippetId;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@Override
	public String toString() {
		return snippetId + "|" + commentId + "|" + tekst + "|" + datum + "|" + userId + "|" + rating.getPositive() + "|" + rating.getNegative();
	}
	
}

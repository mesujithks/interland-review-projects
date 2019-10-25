package jpatest;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the new_notice database table.
 * 
 */
@Entity
@Table(name="new_notice")
@NamedQuery(name="NewNotice.findAll", query="SELECT n FROM NewNotice n")
public class NewNotice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int noticeId;

	private String content;

	private String title;

	public NewNotice() {
	}

	public int getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
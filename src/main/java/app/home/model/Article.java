package app.home.model;

public class Article {
    private String id;

    private Short cid;

    private Boolean type;

    private String title;

    private Integer visitnums;

    private String keywords;

    private Boolean status;

    private String summary;

    private String thumbnail;

    private Integer isdel;

    private Short cuid;

    private long ctime;

    private String uuid;

    private long utime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getCid() {
        return cid;
    }

    public void setCid(Short cid) {
        this.cid = cid;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getVisitnums() {
        return visitnums;
    }

    public void setVisitnums(Integer visitnums) {
        this.visitnums = visitnums;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Short getCuid() {
        return cuid;
    }

    public void setCuid(Short cuid) {
        this.cuid = cuid;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long l) {
        this.ctime = l;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public long getUtime() {
        return utime;
    }

    public void setUtime(long l) {
        this.utime = l;
    }


}
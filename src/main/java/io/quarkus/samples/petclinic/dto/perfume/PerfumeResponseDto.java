package io.quarkus.samples.petclinic.dto.perfume;

public class PerfumeResponseDto {
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPerfumeTitle() {
        return perfumeTitle;
    }
    public void setPerfumeTitle(String perfumeTitle) {
        this.perfumeTitle = perfumeTitle;
    }
    public String getPerfumer() {
        return perfumer;
    }
    public void setPerfumer(String perfumer) {
        this.perfumer = perfumer;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPerfumeGender() {
        return perfumeGender;
    }
    public void setPerfumeGender(String perfumeGender) {
        this.perfumeGender = perfumeGender;
    }
    public String getFragranceTopNotes() {
        return fragranceTopNotes;
    }
    public void setFragranceTopNotes(String fragranceTopNotes) {
        this.fragranceTopNotes = fragranceTopNotes;
    }
    public String getFragranceMiddleNotes() {
        return fragranceMiddleNotes;
    }
    public void setFragranceMiddleNotes(String fragranceMiddleNotes) {
        this.fragranceMiddleNotes = fragranceMiddleNotes;
    }
    public String getFragranceBaseNotes() {
        return fragranceBaseNotes;
    }
    public void setFragranceBaseNotes(String fragranceBaseNotes) {
        this.fragranceBaseNotes = fragranceBaseNotes;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getVolume() {
        return volume;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    private String perfumeTitle;
    private String perfumer;
    private Integer year;
    private String country;
    private String perfumeGender;
    private String fragranceTopNotes;
    private String fragranceMiddleNotes;
    private String fragranceBaseNotes;
    private String description;
    private String filename;
    private Integer price;
    private String volume;
    private String type;

}

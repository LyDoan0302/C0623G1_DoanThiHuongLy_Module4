package com.codegym.model;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto{
    @NotEmpty(message = "Song name is required!")
    @NotBlank(message = "Song name is required!")
    @Size(min=1, max=800, message = "The length of song's name is maximum at 800 characters!")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$",message = "Song's name must not to contain special characters (@,#,$,^,&,*,<,>,...)")
    private String songName;
    //    Tên bài hát. Yêu cầu validate:
//    Không được phép để trống
//
//    Không vượt quá 800 ký tự
//
//    Không chứa các kí tự đặc biệt như @ ; , . = - + , ….
    @NotEmpty(message = "Artist name is required!")
    @NotBlank(message = "Artist name is required!")
    @Size(min=1, max=300, message = "The length of Artist's name is maximum at 300 characters!")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$",message = "Artist's name must not to contain special characters (@,#,$,^,&,*,<,>,...)")
    private String artist;
    //    Nghệ sĩ thể hiện. Yêu cầu validate:
//
//    Không được phép để trống
//
//    Không quá 300 ký tự
//
//    Không chứa các kí tự đặc biệt như @ ; , . = - + , ….
    @NotEmpty(message = "Kind of music is required!")
    @NotBlank(message = "Kind of music is required!")
    @Size(min=1, max=1000, message = "The length of music's kind is maximum at 300 characters!")
    @Pattern(regexp = "^[A-Za-z0-9, ]+$",message = "Music's kind  must not to contain special characters (@,#,$,^,&,*,<,>,...) except [,] ")
    private String kindOfMusic;
//    Thể loại nhạc (nhập thông tin theo dạng text). Yêu cầu validate:
//
//    Không được phép để trống
//
//    Không vượt quá 1000 ký tự
//
//    Ngoại trừ dấu phẩy “,” , các ký tự đặc biệt còn lại không được phép lưu vào DB.
    public SongDto(){}

    public SongDto(String songName, String artist, String kindOfMusic) {
        this.songName = songName;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

}

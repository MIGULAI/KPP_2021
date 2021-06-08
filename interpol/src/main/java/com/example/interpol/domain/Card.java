package com.example.interpol.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
@ToString(of = {"id", "Name" , "FamilyName" , "NickName" , "Height" , "HairColor" , "EyesColor" ,"Citizenship" , "BirthLocation" , "Specialization" , "BirthDay" , "Added"})
@EqualsAndHashCode(of = {"id"})
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String Name;
    private String FamilyName;
    private String NickName;
    private String Height;
    private String HairColor;
    private String EyesColor;
    private String Citizenship;
    private String BirthLocation;
    private String Specialization;

    private String BirthDay;
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MMM-dd HH:mm:ss")
    private LocalDateTime Added;

    public int getId() {
        return id;
    }

    public Card(){

    }
    public Card(String id){
        this.id = Integer.parseInt(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getHairColor() {
        return HairColor;
    }

    public void setHairColor(String hairColor) {
        HairColor = hairColor;
    }

    public String getEyesColor() {
        return EyesColor;
    }

    public void setEyesColor(String eyesColor) {
        EyesColor = eyesColor;
    }

    public String getCitizenship() {
        return Citizenship;
    }

    public void setCitizenship(String citizenship) {
        Citizenship = citizenship;
    }

    public String getBirthLocation() {
        return BirthLocation;
    }

    public void setBirthLocation(String birthLocation) {
        BirthLocation = birthLocation;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String birthDay) {
        BirthDay = birthDay;
    }

    public LocalDateTime getAdded() {
        return Added;
    }

    public void setAdded(LocalDateTime added) {
        Added = added;
    }
}

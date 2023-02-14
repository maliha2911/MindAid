package com.example.mindaid.Dto;

import com.example.mindaid.Model.Doctors;
import com.example.mindaid.Model.Schedule;

import java.util.ArrayList;
import java.util.List;

public class DoctorsScheduleDto {
    public int docId;
    public String day;
    public String dayParameter;
    public String slot1;
    public String slot2;
    public String slot3;
    public String slots;
    public String feeMessage;
    public String feeLive;
    public List<String>chosenConcernList=new ArrayList<>();
    public int [] concerns= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public List<String> selectedSlotMessage=new ArrayList<>();
    public List<String> selectedSlotLive=new ArrayList<>();
    Doctors doctors;
    Schedule schedule;
    List<Schedule>scheduleList;
    public String denialComment;

    public String getDenialComment() {
        return denialComment;
    }

    public void setDenialComment(String denialComment) {
        this.denialComment = denialComment;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }

    public Doctors getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctors doctors) {
        this.doctors = doctors;
    }

    public String getFeeMessage() {
        return feeMessage;
    }

    public void setFeeMessage(String feeMessage) {
        this.feeMessage = feeMessage;
    }

    public String getFeeLive() {
        return feeLive;
    }

    public void setFeeLive(String feeLive) {
        this.feeLive = feeLive;
    }
    public List<String> getSelectedSlotMessage() {
        return selectedSlotMessage;
    }

    public void setSelectedSlotMessage(List<String> selectedSlotMessage) {
        this.selectedSlotMessage = selectedSlotMessage;
    }

    public List<String> getSelectedSlotLive() {
        return selectedSlotLive;
    }

    public void setSelectedSlotLive(List<String> selectedSlotLive) {
        this.selectedSlotLive = selectedSlotLive;
    }

    public int[] getConcerns() {
        return concerns;
    }

    public void setConcerns(int[] concerns) {
        this.concerns = concerns;
    }

    public List<String> getChosenConcernList() {
        return chosenConcernList;
    }

    public void setChosenConcernList(List<String> chosenConcernList) {
        this.chosenConcernList = chosenConcernList;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayParameter() {
        return dayParameter;
    }

    public void setDayParameter(String dayParameter) {
        this.dayParameter = dayParameter;
    }

    public String getSlot1() {
        return slot1;
    }

    public void setSlot1(String slot1) {
        this.slot1 = slot1;
    }

    public String getSlot2() {
        return slot2;
    }

    public void setSlot2(String slot2) {
        this.slot2 = slot2;
    }

    public String getSlot3() {
        return slot3;
    }

    public void setSlot3(String slot3) {
        this.slot3 = slot3;
    }
}

package com.example.hoang.myhkview.hikvision;

public class DvrDeviceInfo {
    public String serverip = "191.168.1.113";
    public int serverport = 8000;
    public String username = "admin";
    public String userpwd = "admin";
    public String describe = "";

    public String serialNumber;

    // The number of analog channels
    public byte channelNumber;

    // Starting number of analog channel, starts from 1
    public byte startChannel = 1;
}

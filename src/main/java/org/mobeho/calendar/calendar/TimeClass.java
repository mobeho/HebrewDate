package org.mobeho.calendar.calendar;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class TimeClass
{
    protected int jiffy;
    protected int hour;

    public TimeClass()
    {
        init();
    }

    void init()
    {
        jiffy = 204;
        hour = 5;
    }

    int addTime(int hourAdd, int jiffyAdd)
    {
        int addDay = 0;
        jiffy += jiffyAdd;

        if (jiffy > 1080 || jiffy < 0)
        {
            hour += jiffy/1080;
            jiffy %= 1080;
        }

        hour += hourAdd;

        if (hour > 24 || hour < 0)
        {
            addDay += hour/24;
            hour %= 24;
        }

        return addDay;
    }

    public void copy(TimeClass timeClass)
    {
        this.hour = timeClass.hour;
        this.jiffy = timeClass.jiffy;
    }

    public String getTimeString() {
        return String.format("%02d:%d(%02d:%02d)", hour, jiffy, (hour+18)%24, (int)(jiffy*60D/1080D));
    }
    public int getJiffy()
    {
        return jiffy;
    }
    public int getHour()
    {
        return hour;
    }
}

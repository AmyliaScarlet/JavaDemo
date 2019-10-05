package com.amyliascarlet.javademo.bean;


import com.amyliascarlet.lib.log.Log;

public class User {
    private String _name;
    private double _money;

    public void setName(String s)
    {
        this._name = s;
    }
    public void setName()
    {
        this._name = "aa";
        Log.i(this);
    }
    public String getName()
    {
        return this._name;
    }

    public void setMoney(double m)
    {
        this._money = m;
    }
    public double getMoney()
    {
        return this._money;
    }

}

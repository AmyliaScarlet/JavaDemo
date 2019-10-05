package com.amyliascarlet.javademo.demo;

import com.amyliascarlet.lib.log.Log;
import com.amyliascarlet.lib.thread.EasyThread;
import com.amyliascarlet.lib.thread.ThreadPoolManager;
import com.amyliascarlet.javademo.bean.User;
import com.amyliascarlet.javademo.elasticsearch.Elasticsearch;
import com.amyliascarlet.javademo.redis.Redis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {
    private static ThreadPoolManager tpm = ThreadPoolManager.getInstance();

	@Test
	public void Elasticsearch_test() {
        new Elasticsearch();

	}


    public void redis_test() {

        Jedis jedis = Redis.getConnection();
        jedis.flushAll();

        //set值
        jedis.set("str1", "1");
        //get值
        String str1 = jedis.get("str1");
        //打印测试
        Log.i(str1);

        jedis.lpush("map", "1", "2");

        List<String> list =jedis.lrange("map",0,-1);
        Log.i(list);

    }


    public void Print_test()
    {
        pBean();

    }


    public void thred_test()
    {
        Log.i("parent thread begin ");

        EasyThread t1 = new EasyThread("et");
        EasyThread t2 = new EasyThread("et");
        t1.start();
        //t2.start();

        Log.i("parent thread over ");
    }


    public void et()
    {

        User u = new User();
        Log.i(u);
        EasyThread t1 = new EasyThread(User.class,"setName");
        t1.start();
        Log.i(u);

    }

    private void DoInT3(){
        for(int i=54;i<59;i++){
            Log.i(i);
            //System.out.print(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void pBean() {
        //1 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2 向容器"要"对象
        User u = (User) ac.getBean("user");

        u.setName("a");
        u.setMoney(12);

        Log.i(u);
    }

}


package io.github.eastseven.android.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class RabbitmqService extends Service {

	private static final String tag = "D7_RabbitmqService";
	
	private final static String QUEUE_NAME = "hello";
	private final static String HOST       = "192.168.1.55";
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(tag, "RabbitmqService.onCreate");
		
		reciveMessage();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(tag, "onStartCommand, intent="+intent+", flags="+flags+", startId="+startId);
		return super.onStartCommand(intent, flags, startId);
	}
	
	void reciveMessage() {
		Log.d(tag, "reciveMessage...");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					ConnectionFactory factory = new ConnectionFactory();
					factory.setHost(HOST);
					Connection connection = factory.newConnection();
					Channel channel = connection.createChannel();
					
					channel.queueDeclare(QUEUE_NAME, false, false, false, null);
					
					QueueingConsumer consumer = new QueueingConsumer(channel);
					channel.basicConsume(QUEUE_NAME, true, consumer);
					
					while (true) {
						QueueingConsumer.Delivery delivery = consumer.nextDelivery();
						String message = new String(delivery.getBody());
						Log.d(tag, " [x] Received '" + message + "'");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}

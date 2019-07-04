package com.understandmusic;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class UnderstandMusic extends Applet {
	private static final long serialVersionUID = 1L;
	JCheckBox box1, box2;	//复选框
	JButton play, loop, stop;
	AudioClip audio1 = null;	//创建AudioClip对象并初始化
	AudioClip audio2 = null;
	JLabel label;
	
	public void init() {
		resize(400, 200);
		this.setLayout(null); //取消容器的布局管理器
		box1 = new JCheckBox("msg.wav");
		box2 = new JCheckBox("SoundTest.wav");
		box1.setBounds(65, 15, 140, 35);
		box2.setBounds(200, 15, 180, 35);
		add(box1);
		add(box2);
		
		play = new JButton("播放");
		loop = new JButton("循环");
		stop = new JButton("停止");
		
		play.setBounds(50, 65, 80, 30);
		loop.setBounds(150, 65, 80, 30);
		stop.setBounds(250, 65, 80, 30);
		stop.setEnabled(false);
		
		audio1 = getAudioClip(getCodeBase(), "msg.wav"); //getCodeBase()返回Applet小应用程序的URL
		audio2 = getAudioClip(getCodeBase(), "SoundTest.wav");
		
		
		/*
		 * 使用匿名类创建对象时，Java允许把类体与对象的创建组合在一起；并重写抽象方法
		 */
		add(play);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playActionPerformed(e);
			}
		});
		
		add(loop);
		loop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loopActionPerformed(e);
			}
		});
		
		add(stop);
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopActionPerformed(e);
			}
		});
		
		label = new JLabel();
		label.setBounds(65, 100, 400, 35);
		add(label);
		label.setText("请选择歌曲后按键");
	}

	private void stopActionPerformed(ActionEvent e) {
		audio1.stop();
		audio2.stop();
		play.setEnabled(true);
		loop.setEnabled(true);
		stop.setEnabled(false);
		label.setText("停止播放");
	}

	private void loopActionPerformed(ActionEvent e) {
		if (audio1 != null && box1.isSelected()) {
			audio1.loop();
			play.setEnabled(false);
			loop.setEnabled(false);
			stop.setEnabled(true);
			label.setText("正在循环播放！");
		}
		if (audio2 != null && box2.isSelected()) {
			audio2.loop();
			play.setEnabled(false);
			loop.setEnabled(false);
			stop.setEnabled(true);
			label.setText("正在循环播放！");
		} else
			label.setText("请确保msg.wav和SoundTest.wav与测试程序在统一路径");
	}

	private void playActionPerformed(ActionEvent e) {
		if (audio1 != null && box1.isSelected()) {
			audio1.play();
			play.setEnabled(false);
			loop.setEnabled(false);
			stop.setEnabled(true);
			label.setText("正在单次播放！");
		}
		if (audio2 != null && box2.isSelected()) {
			audio2.play();
			play.setEnabled(false);
			loop.setEnabled(false);
			stop.setEnabled(true);
			label.setText("正在单次播放！");
		} else
			label.setText("请确保msg.wav和SoundTest.wav与测试程序在统一路径");
	}
}

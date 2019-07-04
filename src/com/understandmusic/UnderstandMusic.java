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
	JCheckBox box1, box2;	//��ѡ��
	JButton play, loop, stop;
	AudioClip audio1 = null;	//����AudioClip���󲢳�ʼ��
	AudioClip audio2 = null;
	JLabel label;
	
	public void init() {
		resize(400, 200);
		this.setLayout(null); //ȡ�������Ĳ��ֹ�����
		box1 = new JCheckBox("msg.wav");
		box2 = new JCheckBox("SoundTest.wav");
		box1.setBounds(65, 15, 140, 35);
		box2.setBounds(200, 15, 180, 35);
		add(box1);
		add(box2);
		
		play = new JButton("����");
		loop = new JButton("ѭ��");
		stop = new JButton("ֹͣ");
		
		play.setBounds(50, 65, 80, 30);
		loop.setBounds(150, 65, 80, 30);
		stop.setBounds(250, 65, 80, 30);
		stop.setEnabled(false);
		
		audio1 = getAudioClip(getCodeBase(), "msg.wav"); //getCodeBase()����AppletСӦ�ó����URL
		audio2 = getAudioClip(getCodeBase(), "SoundTest.wav");
		
		
		/*
		 * ʹ�������ഴ������ʱ��Java��������������Ĵ��������һ�𣻲���д���󷽷�
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
		label.setText("��ѡ������󰴼�");
	}

	private void stopActionPerformed(ActionEvent e) {
		audio1.stop();
		audio2.stop();
		play.setEnabled(true);
		loop.setEnabled(true);
		stop.setEnabled(false);
		label.setText("ֹͣ����");
	}

	private void loopActionPerformed(ActionEvent e) {
		if (audio1 != null && box1.isSelected()) {
			audio1.loop();
			play.setEnabled(false);
			loop.setEnabled(false);
			stop.setEnabled(true);
			label.setText("����ѭ�����ţ�");
		}
		if (audio2 != null && box2.isSelected()) {
			audio2.loop();
			play.setEnabled(false);
			loop.setEnabled(false);
			stop.setEnabled(true);
			label.setText("����ѭ�����ţ�");
		} else
			label.setText("��ȷ��msg.wav��SoundTest.wav����Գ�����ͳһ·��");
	}

	private void playActionPerformed(ActionEvent e) {
		if (audio1 != null && box1.isSelected()) {
			audio1.play();
			play.setEnabled(false);
			loop.setEnabled(false);
			stop.setEnabled(true);
			label.setText("���ڵ��β��ţ�");
		}
		if (audio2 != null && box2.isSelected()) {
			audio2.play();
			play.setEnabled(false);
			loop.setEnabled(false);
			stop.setEnabled(true);
			label.setText("���ڵ��β��ţ�");
		} else
			label.setText("��ȷ��msg.wav��SoundTest.wav����Գ�����ͳһ·��");
	}
}

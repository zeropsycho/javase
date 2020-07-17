package javase.intefacedemo;

/**
 * 手机功能
 */
public class OldPhone implements Phone {
    @Override
    public void sendMessage() {
        System.out.println("发信息");
    }

    @Override
    public void makePhoneTell() {
        System.out.println("打电话");
    }

    // 新增加的功能

    /**
     * 音频
     */
    @Override
    public void audio() {
        System.out.println("音频");
    }

    @Override
    public void video() {
        System.out.println("视频");
    }
}

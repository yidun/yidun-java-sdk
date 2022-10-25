package com.netease.yidun.sdk.antispam;

import com.netease.yidun.sdk.antispam.audio.AudioCheckClient;
import com.netease.yidun.sdk.antispam.audio.AudioCommonClient;
import com.netease.yidun.sdk.antispam.crawler.CrawlerCallbackClient;
import com.netease.yidun.sdk.antispam.crawler.CrawlerSubmitClient;
import com.netease.yidun.sdk.antispam.digitalbook.v2.DigitalBookCheckClient;
import com.netease.yidun.sdk.antispam.digitalbook.v2.DigitalBookQueryClient;
import com.netease.yidun.sdk.antispam.file.v2.FileSolutionCallbackClient;
import com.netease.yidun.sdk.antispam.file.v2.FileSolutionCheckClient;
import com.netease.yidun.sdk.antispam.grammarfix.GrammarfixCommonClient;
import com.netease.yidun.sdk.antispam.image.v5.ImageCheckClient;
import com.netease.yidun.sdk.antispam.image.v5.ImageCommonClient;
import com.netease.yidun.sdk.antispam.keyword.KeywordCommonClient;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.ImageListCommonClient;
import com.netease.yidun.sdk.antispam.list.user.v2.ListCommonClient;
import com.netease.yidun.sdk.antispam.liveaudio.LiveAudioCheckClient;
import com.netease.yidun.sdk.antispam.liveaudio.LiveAudioCommonClient;
import com.netease.yidun.sdk.antispam.livevideo.LiveVideoCheckClient;
import com.netease.yidun.sdk.antispam.livevideo.LiveVideoCommonClient;
import com.netease.yidun.sdk.antispam.livevideosolution.LiveVideoSolutionCheckClient;
import com.netease.yidun.sdk.antispam.livevideosolution.LiveVideoSolutionCommonClient;
import com.netease.yidun.sdk.antispam.media.v2.MediaCheckClient;
import com.netease.yidun.sdk.antispam.media.v2.MediaQueryClient;
import com.netease.yidun.sdk.antispam.pretreatment.PretreatmentCommonClient;
import com.netease.yidun.sdk.antispam.report.v1.ReportCheckClient;
import com.netease.yidun.sdk.antispam.report.v1.ReportQueryClient;
import com.netease.yidun.sdk.antispam.text.TextCheckClient;
import com.netease.yidun.sdk.antispam.text.TextCommonClient;
import com.netease.yidun.sdk.antispam.video.VideoCheckClient;
import com.netease.yidun.sdk.antispam.video.VideoCommonClient;
import com.netease.yidun.sdk.antispam.videosolution.VideoSolutionCheckClient;
import com.netease.yidun.sdk.antispam.videosolution.VideoSolutionCommonClient;
import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.http.HttpClientConfig;
import com.netease.yidun.sdk.core.utils.AssertUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 反垃圾请求器
 */
public class AntispamRequester {

    private ClientProfile clientProfile;
    private ConcurrentHashMap<String, Object> clientMap = new ConcurrentHashMap<>();

    public AntispamRequester(String secretId, String secretKey) {
        AssertUtils.notBlank(secretId, "secretId can not be null or empty");
        AssertUtils.notBlank(secretKey, "secretKey can not be null or empty");
        this.clientProfile = createDefaultProfile(secretId, secretKey);
    }

    public AntispamRequester(ClientProfile clientProfile) {
        AssertUtils.notNull(clientProfile, "clientProfile can not be null");
        AssertUtils.notNull(clientProfile.credentials(), "credentials can not be null");
        AssertUtils.notBlank(clientProfile.credentials().secretId(), "secretId can not be null or empty");
        AssertUtils.notBlank(clientProfile.credentials().secretKey(), "secretKey can not be null or empty");

        this.clientProfile = clientProfile;
    }

    public static ClientProfile createDefaultProfile(String secretId, String secretKey) {
        ClientProfile clientProfile = ClientProfile.defaultProfile(new Credentials(secretId, secretKey));

        HttpClientConfig clientConfig = new HttpClientConfig();
        clientConfig.setMaxConnectionCountPerRoute(100);
        clientProfile.setHttpClientConfig(clientConfig);

        return clientProfile;
    }

    public ImageCheckClient getImageCheckClient() {
        return createIfAbsent(ImageCheckClient.class);
    }

    public ImageCommonClient getImageCommonClient() {
        return createIfAbsent(ImageCommonClient.class);
    }

    public AudioCheckClient getAudioCheckClient() {
        return createIfAbsent(AudioCheckClient.class);
    }

    public AudioCommonClient getAudioCommonClient() {
        return createIfAbsent(AudioCommonClient.class);
    }

    public VideoCheckClient getVideoCheckClient() {
        return createIfAbsent(VideoCheckClient.class);
    }

    public VideoCommonClient getVideoCommonClient() {
        return createIfAbsent(VideoCommonClient.class);
    }

    public VideoSolutionCheckClient getVideoSolutionCheckClient() {
        return createIfAbsent(VideoSolutionCheckClient.class);
    }

    public VideoSolutionCommonClient getVideoSolutionCommonClient() {
        return createIfAbsent(VideoSolutionCommonClient.class);
    }

    public LiveAudioCheckClient getLiveAudioCheckClient() {
        return createIfAbsent(LiveAudioCheckClient.class);
    }

    public LiveAudioCommonClient getLiveAudioCommonClient() {
        return createIfAbsent(LiveAudioCommonClient.class);
    }

    public LiveVideoCheckClient getLiveVideoCheckClient() {
        return createIfAbsent(LiveVideoCheckClient.class);
    }

    public LiveVideoCommonClient getLiveVideoCommonClient() {
        return createIfAbsent(LiveVideoCommonClient.class);
    }

    public LiveVideoSolutionCheckClient getLiveVideoSolutionCheckClient() {
        return createIfAbsent(LiveVideoSolutionCheckClient.class);
    }

    public LiveVideoSolutionCommonClient getLiveVideoSolutionCommonClient() {
        return createIfAbsent(LiveVideoSolutionCommonClient.class);
    }

    public TextCheckClient getTextCheckClient() {
        return createIfAbsent(TextCheckClient.class);
    }

    public TextCommonClient getTextCommonClient() {
        return createIfAbsent(TextCommonClient.class);
    }

    public MediaCheckClient getMediaCheckClient() {
        return createIfAbsent(MediaCheckClient.class);
    }

    public MediaQueryClient getMediaQueryClient() {
        return createIfAbsent(MediaQueryClient.class);
    }

    public ReportCheckClient getReportCheckClient() {
        return createIfAbsent(ReportCheckClient.class);
    }

    public ReportQueryClient getReportQueryClient() {
        return createIfAbsent(ReportQueryClient.class);
    }

    public DigitalBookCheckClient getDigitalBookCheckClient() {
        return createIfAbsent(DigitalBookCheckClient.class);
    }

    public DigitalBookQueryClient getDigitalBookQueryClient() {
        return createIfAbsent(DigitalBookQueryClient.class);
    }

    public FileSolutionCheckClient getFileSolutionCheckClient() {
        return createIfAbsent(FileSolutionCheckClient.class);
    }

    public FileSolutionCallbackClient getFileSolutionQueryClient() {
        return createIfAbsent(FileSolutionCallbackClient.class);
    }

    public CrawlerCallbackClient getCrawlerCallbackClient() {
        return createIfAbsent(CrawlerCallbackClient.class);
    }

    public CrawlerSubmitClient getCrawlerSubmitClient() {
        return createIfAbsent(CrawlerSubmitClient.class);
    }

    public GrammarfixCommonClient getGrammarfixCommonClient() {
        return createIfAbsent(GrammarfixCommonClient.class);
    }

    public KeywordCommonClient getKeywordCommonClient() {
        return createIfAbsent(KeywordCommonClient.class);
    }

    public ImageListCommonClient getImageListCommonClient() {
        return createIfAbsent(ImageListCommonClient.class);
    }

    public ListCommonClient getListCommonClient() {
        return createIfAbsent(ListCommonClient.class);
    }

    public PretreatmentCommonClient getPretreatmentCommonClient() {
        return createIfAbsent(PretreatmentCommonClient.class);
    }

    private <T extends AntispamClient> T createIfAbsent(Class<T> clazz) {
        String name = clazz.getName();
        Object client = clientMap.get(name);
        if (client != null) {
            return (T) client;
        }
        return (T) clientMap.computeIfAbsent(name, k -> {
            try {
                return clazz.getDeclaredConstructor(ClientProfile.class).newInstance(clientProfile);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}

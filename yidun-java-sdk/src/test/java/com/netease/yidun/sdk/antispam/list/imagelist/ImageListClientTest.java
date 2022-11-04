package com.netease.yidun.sdk.antispam.list.imagelist;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.image.Constants;
import com.netease.yidun.sdk.antispam.list.ListClient;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.delete.ImageListDeleteRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.delete.ImageListDeleteResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.query.ImageListQueryRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.query.ImageListQueryResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.submit.ImageListSubmitRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.submit.ImageListSubmitResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.update.ImageListUpdateRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.update.ImageListUpdateResponse;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ImageListClientTest {

    private static final Gson GSON = new Gson();
    private static long currentTimeMillis = System.currentTimeMillis();
    private static ListClient client;

    @Before
    public void pre() {
        AntispamRequester antispamRequester = new AntispamRequester(Constants.SECRET_ID, Constants.SECRET_KEY);
        client = new ListClient(antispamRequester);
    }

    @Test
    public void testCase() {

        // 测试add
        ImageListSubmitResponse response = add();

        String url = response.getResult().getSuccessImages().get(0).getImage();
        String uuid = response.getResult().getSuccessImages().get(0).getUuid();
        String md5 = response.getResult().getSuccessImages().get(0).getMd5();

        // 测试query
        ImageListQueryRequest imageListQueryRequest = query(url);

        // 测试update
        update(uuid);

        // 测试update后的query
        queryAfterupdate(imageListQueryRequest);

        // 测试delete
        delete(uuid);

        // 测试delete后的query
        queryAfteDelete(imageListQueryRequest);
    }

    private void queryAfteDelete(ImageListQueryRequest imageListQueryRequest) {
        imageListQueryRequest.setStatus(null);
        ImageListQueryResponse imageListQueryResponseAfterDelete = client.queryImageList(imageListQueryRequest);
        Assert.assertNotNull(imageListQueryResponseAfterDelete);
        Assert.assertEquals(0, (long) imageListQueryResponseAfterDelete.getResult().getCount());
    }

    private void delete(String uuid) {
        ImageListDeleteRequest imageListDeleteRequest = new ImageListDeleteRequest();
        imageListDeleteRequest.protocol(ProtocolEnum.HTTP);
        imageListDeleteRequest.setBusinessId(Constants.BUSINESS_ID);
        imageListDeleteRequest.nonce(String.valueOf(currentTimeMillis++));
        imageListDeleteRequest.setUuid(uuid);
        imageListDeleteRequest.setType(1);
        ImageListDeleteResponse imageListDeleteResponse = client.deleteImageList(imageListDeleteRequest);
        Assert.assertTrue(imageListDeleteResponse.getResult());
    }

    private ImageListSubmitResponse add() {
        ImageListSubmitRequest imageListSubmitRequest = new ImageListSubmitRequest();
        imageListSubmitRequest.protocol(ProtocolEnum.HTTP);
        imageListSubmitRequest.nonce(String.valueOf(currentTimeMillis++));
        imageListSubmitRequest.setBusinessId(Constants.BUSINESS_ID);
        Set<String> images = new HashSet<>();
        images.add("https://cdn.wmpvp.com/appactivity/86C57E9222284508AB31732EB0CC785D-1666606388920/0e4adf5f982ac5b3b29368ce2c61f147.png?x-oss-process=image/resize,m_fixed,h_466,w_828");
        images.add("https://watch-ablum.xiaotiancai.com/camera_album_pro_1666606391208_akzpgkvpdlxbdplmIMG20221024181309.jpg?e=1667211192&token=UCAgtcR1BmKTKrnXCgBJoaJB7I4fRsqCVRqRouES:dUfXfzhyZJRiXq5ABT2W0uh3MwQ=");
        imageListSubmitRequest.setImages(GSON.toJson(images));
        imageListSubmitRequest.setListType(2);
        imageListSubmitRequest.setImageLabel(100);
        imageListSubmitRequest.setImageType(1);
        imageListSubmitRequest.setType(1);
        imageListSubmitRequest.setDescription("图片名单描述");

        ImageListSubmitResponse response = client.submitImageList(imageListSubmitRequest);
        System.out.print(response.toString());
        Assert.assertNotNull(response);
        Assert.assertEquals(200, response.getCode());
        Assert.assertNotNull(response.getResult());
        return response;
    }

    private ImageListQueryRequest query(String url) {
        ImageListQueryRequest imageListQueryRequest = new ImageListQueryRequest();
        imageListQueryRequest.protocol(ProtocolEnum.HTTP);
        imageListQueryRequest.setBusinessId(Constants.BUSINESS_ID);
        imageListQueryRequest.nonce(String.valueOf(currentTimeMillis++));
        imageListQueryRequest.setUrl(url);
        imageListQueryRequest.setListType(2);
        imageListQueryRequest.setImageLabel(100);
        imageListQueryRequest.setType(1);
        imageListQueryRequest.setStatus(1);
        imageListQueryRequest.setStartTime(System.currentTimeMillis() - 10 * 60 * 1000);
        imageListQueryRequest.setEndTime(System.currentTimeMillis() + 10 * 60 * 1000);
        imageListQueryRequest.setPageNum(1);
        imageListQueryRequest.setPageSize(20);
        ImageListQueryResponse imageListQueryResponse = client.queryImageList(imageListQueryRequest);
        Assert.assertNotNull(imageListQueryResponse);
        return imageListQueryRequest;
    }

    private void update(String uuid) {
        ImageListUpdateRequest imageListUpdateRequest = new ImageListUpdateRequest();
        imageListUpdateRequest.protocol(ProtocolEnum.HTTP);
        imageListUpdateRequest.setBusinessId(Constants.BUSINESS_ID);
        imageListUpdateRequest.nonce(String.valueOf(currentTimeMillis++));
        imageListUpdateRequest.setUuid(uuid);
        imageListUpdateRequest.setType(1);
        imageListUpdateRequest.setStatus(0);
        ImageListUpdateResponse imageListUpdateResponse = client.updateImageList(imageListUpdateRequest);
        Assert.assertEquals(200, imageListUpdateResponse.getCode());
        Assert.assertTrue(imageListUpdateResponse.getResult());
    }

    private void queryAfterupdate(ImageListQueryRequest imageListQueryRequest) {
        ImageListQueryResponse imageListQueryResponseAfterUpdate = client.queryImageList(imageListQueryRequest);
        Assert.assertNotNull(imageListQueryResponseAfterUpdate);
        Assert.assertEquals(200, imageListQueryResponseAfterUpdate.getCode());
        Assert.assertEquals(0, (long) imageListQueryResponseAfterUpdate.getResult().getCount());
        imageListQueryRequest.setStatus(0);
        ImageListQueryResponse imageListQueryInvalidResponseAfterUpdate = client.queryImageList(imageListQueryRequest);
        Assert.assertNotNull(imageListQueryInvalidResponseAfterUpdate);
        Assert.assertEquals(200, imageListQueryInvalidResponseAfterUpdate.getCode());
        Assert.assertEquals(1, (long) imageListQueryInvalidResponseAfterUpdate.getResult().getCount());
    }
}

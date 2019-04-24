package yhao.micro.web.surety.controller.security.open;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yhao.infra.feature.imgupload.core.UploadComponent;
import yhao.infra.feature.imgupload.core.UploadRequest;
import yhao.infra.feature.imgupload.core.UploadResult;
import yhao.micro.web.surety.enums.WebReturnCodeEnum;
import yhao.micro.web.surety.controller.WebBaseController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:文件处理Controller，包含上传，下载
 * User: GUO.MAO.LIN
 * Date: 2018-12-14
 * Time: 10:49
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/file", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenFileController", tags = "开放-文件操作")
public class OpenFileController extends WebBaseController {
    private Logger logger = LoggerFactory.getLogger(OpenFileController.class);
    @Resource
    private UploadComponent uploadComponent;

    @PostMapping(value = "/upload", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "文件上传")
    @ApiResponses({
            @ApiResponse(code = 200, response = UploadResult.class, message = "文件上传")
    })
    public String upload(@ApiParam(value = "文件", required = true) MultipartFile file) {
        try {
            return returnSuccessInfo(uploadComponent.fileUpload(new UploadRequest(file)));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return returnWrong(WebReturnCodeEnum.F1000);
        }
    }

    @GetMapping("/download")
    @ApiOperation(value = "文件下载")
    @ApiResponses({
            @ApiResponse(code = 200, response = UploadResult.class, message = "文件下载")
    })
    public String download(HttpServletRequest request, HttpServletResponse response, String url, String fileName) {
        try {
            uploadComponent.downloadAttachment(request, response, url, fileName);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return returnWrong(WebReturnCodeEnum.F1001);
        }
        return returnSuccessInfo();
    }
}

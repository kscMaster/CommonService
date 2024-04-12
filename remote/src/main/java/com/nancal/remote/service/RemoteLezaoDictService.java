package com.nancal.remote.service;

import com.nancal.common.base.Response;
import com.nancal.remote.to.DictTypeListTo;
import com.nancal.remote.to.MoreDictEntryReq;
import com.nancal.remote.vo.DictItemVo;
import com.nancal.remote.vo.MoreDictEntryGroupVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(contextId = "remoteLezaoDictService",name = "lezao-dict-service"
//    ,url = "http://120.46.143.248/api/lezao-dict-service"
)
public interface RemoteLezaoDictService {

    /***
     * 根据字典类型查询字典项列表
     *
     * @param to 请求类型参数
     * @author 徐鹏军
     * @date 2022/4/8 17:05
     * @return {@link Response< List< DictItemVo>>}
     */
    @PostMapping("/lezaoDictionaries/list")
    public Response<List<DictItemVo>> list(@RequestBody DictTypeListTo to);


    /***
     * 根据字典类型查询字典项列表
     *
     * @param moreDictEntryReq 请求类型参数
     * @author 徐鹏军
     * @date 2022/4/8 17:05
     * @return {@link Response< List< DictItemVo>>}
     */
    @PostMapping("lezaoDictionaries/getMoreDictEntryGroup")
    public Response<List<MoreDictEntryGroupVo>> getMoreDictEntryGroup(@RequestBody MoreDictEntryReq moreDictEntryReq);

    /***
     * 根据数据字典项编码&字典项名称查询对应的值
     *
     * @param dictName 字典名称
     * @param dictTypeCode 字典类型编码
     * @author 徐鹏军
     * @date 2022/4/8 17:05
     * @return {@link Response<String>>}
     */
    @GetMapping("/lezaoDictionaries/getDictValue")
    public Response<String> getValueByTypeAndName(@RequestParam("dictName") String dictName,@RequestParam("dictTypeCode") String dictTypeCode);


    @PostMapping("/lezaoDictionaries/list/like")
    public Response<Map<String,List<DictItemVo>>> like(@RequestBody DictTypeListTo to);


    @PostMapping("/lezaoDictionaries/getMoreDictEntry")
    public Response<List<DictItemVo>> getMoreDictEntry(@RequestBody DictTypeListTo to);

}

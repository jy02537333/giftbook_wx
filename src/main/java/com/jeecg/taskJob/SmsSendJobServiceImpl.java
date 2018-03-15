package com.jeecg.taskJob;

import com.jeecg.service.giftbook.InvitationlistServiceI;
import org.jeecgframework.web.system.service.TimeTaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("smsSendJobService")
public class SmsSendJobServiceImpl {
	
	@Autowired
	private TimeTaskServiceI timeTaskService;
	@Autowired
	private InvitationlistServiceI invitationlistService;
	public void work()
	{
//		System.out.println(new Date().toGMTString()+"::SmsSendJobServiceImpl1111111111111111111111\n111111111111111");
//		SmsSendCtrl sendCtrl=new SmsSendCtrl();
//		List<InvitationlistEntity>list=invitationlistService.findByProperty(InvitationlistEntity.class
//				, "issend", 0);
//		for	(InvitationlistEntity item :list)
//		{
//			int ret=sendCtrl.sendInvitationInfo(item.getInviteephone(), item.getInvitationName(), item.getInvitationid());
//					if(ret>0)
//					{
//						invitationlistService.updateEntitie(item);
//					}
//		}
	}
}

package com.github.notification.config;

import java.util.List;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.AddPermissionRequest;
import com.amazonaws.services.sns.model.AddPermissionResult;
import com.amazonaws.services.sns.model.CheckIfPhoneNumberIsOptedOutRequest;
import com.amazonaws.services.sns.model.CheckIfPhoneNumberIsOptedOutResult;
import com.amazonaws.services.sns.model.ConfirmSubscriptionRequest;
import com.amazonaws.services.sns.model.ConfirmSubscriptionResult;
import com.amazonaws.services.sns.model.CreatePlatformApplicationRequest;
import com.amazonaws.services.sns.model.CreatePlatformApplicationResult;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;
import com.amazonaws.services.sns.model.CreateSMSSandboxPhoneNumberRequest;
import com.amazonaws.services.sns.model.CreateSMSSandboxPhoneNumberResult;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.DeleteEndpointRequest;
import com.amazonaws.services.sns.model.DeleteEndpointResult;
import com.amazonaws.services.sns.model.DeletePlatformApplicationRequest;
import com.amazonaws.services.sns.model.DeletePlatformApplicationResult;
import com.amazonaws.services.sns.model.DeleteSMSSandboxPhoneNumberRequest;
import com.amazonaws.services.sns.model.DeleteSMSSandboxPhoneNumberResult;
import com.amazonaws.services.sns.model.DeleteTopicRequest;
import com.amazonaws.services.sns.model.DeleteTopicResult;
import com.amazonaws.services.sns.model.GetDataProtectionPolicyRequest;
import com.amazonaws.services.sns.model.GetDataProtectionPolicyResult;
import com.amazonaws.services.sns.model.GetEndpointAttributesRequest;
import com.amazonaws.services.sns.model.GetEndpointAttributesResult;
import com.amazonaws.services.sns.model.GetPlatformApplicationAttributesRequest;
import com.amazonaws.services.sns.model.GetPlatformApplicationAttributesResult;
import com.amazonaws.services.sns.model.GetSMSAttributesRequest;
import com.amazonaws.services.sns.model.GetSMSAttributesResult;
import com.amazonaws.services.sns.model.GetSMSSandboxAccountStatusRequest;
import com.amazonaws.services.sns.model.GetSMSSandboxAccountStatusResult;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesResult;
import com.amazonaws.services.sns.model.GetTopicAttributesRequest;
import com.amazonaws.services.sns.model.GetTopicAttributesResult;
import com.amazonaws.services.sns.model.ListEndpointsByPlatformApplicationRequest;
import com.amazonaws.services.sns.model.ListEndpointsByPlatformApplicationResult;
import com.amazonaws.services.sns.model.ListOriginationNumbersRequest;
import com.amazonaws.services.sns.model.ListOriginationNumbersResult;
import com.amazonaws.services.sns.model.ListPhoneNumbersOptedOutRequest;
import com.amazonaws.services.sns.model.ListPhoneNumbersOptedOutResult;
import com.amazonaws.services.sns.model.ListPlatformApplicationsRequest;
import com.amazonaws.services.sns.model.ListPlatformApplicationsResult;
import com.amazonaws.services.sns.model.ListSMSSandboxPhoneNumbersRequest;
import com.amazonaws.services.sns.model.ListSMSSandboxPhoneNumbersResult;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.ListSubscriptionsRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsResult;
import com.amazonaws.services.sns.model.ListTagsForResourceRequest;
import com.amazonaws.services.sns.model.ListTagsForResourceResult;
import com.amazonaws.services.sns.model.ListTopicsRequest;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.OptInPhoneNumberRequest;
import com.amazonaws.services.sns.model.OptInPhoneNumberResult;
import com.amazonaws.services.sns.model.PublishBatchRequest;
import com.amazonaws.services.sns.model.PublishBatchResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.PutDataProtectionPolicyRequest;
import com.amazonaws.services.sns.model.PutDataProtectionPolicyResult;
import com.amazonaws.services.sns.model.RemovePermissionRequest;
import com.amazonaws.services.sns.model.RemovePermissionResult;
import com.amazonaws.services.sns.model.SetEndpointAttributesRequest;
import com.amazonaws.services.sns.model.SetEndpointAttributesResult;
import com.amazonaws.services.sns.model.SetPlatformApplicationAttributesRequest;
import com.amazonaws.services.sns.model.SetPlatformApplicationAttributesResult;
import com.amazonaws.services.sns.model.SetSMSAttributesRequest;
import com.amazonaws.services.sns.model.SetSMSAttributesResult;
import com.amazonaws.services.sns.model.SetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.SetSubscriptionAttributesResult;
import com.amazonaws.services.sns.model.SetTopicAttributesRequest;
import com.amazonaws.services.sns.model.SetTopicAttributesResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.amazonaws.services.sns.model.TagResourceRequest;
import com.amazonaws.services.sns.model.TagResourceResult;
import com.amazonaws.services.sns.model.UnsubscribeRequest;
import com.amazonaws.services.sns.model.UnsubscribeResult;
import com.amazonaws.services.sns.model.UntagResourceRequest;
import com.amazonaws.services.sns.model.UntagResourceResult;
import com.amazonaws.services.sns.model.VerifySMSSandboxPhoneNumberRequest;
import com.amazonaws.services.sns.model.VerifySMSSandboxPhoneNumberResult;

public class AmazonSnsMock implements AmazonSNS {

	@Override
	public PublishResult publish(PublishRequest publishRequest) {
		PublishResult result = new PublishResult();
		result.setMessageId("mockMessageId");
		return result;
	}
	
	@Override
	public void setEndpoint(String endpoint) {

	}

	@Override
	public void setRegion(Region region) {

	}

	@Override
	public AddPermissionResult addPermission(AddPermissionRequest addPermissionRequest) {
		return null;
	}

	@Override
	public AddPermissionResult addPermission(String topicArn, String label, List<String> aWSAccountIds,
			List<String> actionNames) {
		return null;
	}

	@Override
	public CheckIfPhoneNumberIsOptedOutResult checkIfPhoneNumberIsOptedOut(
			CheckIfPhoneNumberIsOptedOutRequest checkIfPhoneNumberIsOptedOutRequest) {
		return null;
	}

	@Override
	public ConfirmSubscriptionResult confirmSubscription(ConfirmSubscriptionRequest confirmSubscriptionRequest) {
		return null;
	}

	@Override
	public ConfirmSubscriptionResult confirmSubscription(String topicArn, String token,
			String authenticateOnUnsubscribe) {
		return null;
	}

	@Override
	public ConfirmSubscriptionResult confirmSubscription(String topicArn, String token) {
		return null;
	}

	@Override
	public CreatePlatformApplicationResult createPlatformApplication(
			CreatePlatformApplicationRequest createPlatformApplicationRequest) {
		return null;
	}

	@Override
	public CreatePlatformEndpointResult createPlatformEndpoint(
			CreatePlatformEndpointRequest createPlatformEndpointRequest) {
		return null;
	}

	@Override
	public CreateSMSSandboxPhoneNumberResult createSMSSandboxPhoneNumber(
			CreateSMSSandboxPhoneNumberRequest createSMSSandboxPhoneNumberRequest) {
		return null;
	}

	@Override
	public CreateTopicResult createTopic(CreateTopicRequest createTopicRequest) {
		return null;
	}

	@Override
	public CreateTopicResult createTopic(String name) {
		return null;
	}

	@Override
	public DeleteEndpointResult deleteEndpoint(DeleteEndpointRequest deleteEndpointRequest) {
		return null;
	}

	@Override
	public DeletePlatformApplicationResult deletePlatformApplication(
			DeletePlatformApplicationRequest deletePlatformApplicationRequest) {
		return null;
	}

	@Override
	public DeleteSMSSandboxPhoneNumberResult deleteSMSSandboxPhoneNumber(
			DeleteSMSSandboxPhoneNumberRequest deleteSMSSandboxPhoneNumberRequest) {
		return null;
	}

	@Override
	public DeleteTopicResult deleteTopic(DeleteTopicRequest deleteTopicRequest) {
		return null;
	}

	@Override
	public DeleteTopicResult deleteTopic(String topicArn) {
		return null;
	}

	@Override
	public GetDataProtectionPolicyResult getDataProtectionPolicy(
			GetDataProtectionPolicyRequest getDataProtectionPolicyRequest) {
		return null;
	}

	@Override
	public GetEndpointAttributesResult getEndpointAttributes(
			GetEndpointAttributesRequest getEndpointAttributesRequest) {
		return null;
	}

	@Override
	public GetPlatformApplicationAttributesResult getPlatformApplicationAttributes(
			GetPlatformApplicationAttributesRequest getPlatformApplicationAttributesRequest) {
		return null;
	}

	@Override
	public GetSMSAttributesResult getSMSAttributes(GetSMSAttributesRequest getSMSAttributesRequest) {
		return null;
	}

	@Override
	public GetSMSSandboxAccountStatusResult getSMSSandboxAccountStatus(
			GetSMSSandboxAccountStatusRequest getSMSSandboxAccountStatusRequest) {
		return null;
	}

	@Override
	public GetSubscriptionAttributesResult getSubscriptionAttributes(
			GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) {
		return null;
	}

	@Override
	public GetSubscriptionAttributesResult getSubscriptionAttributes(String subscriptionArn) {
		return null;
	}

	@Override
	public GetTopicAttributesResult getTopicAttributes(GetTopicAttributesRequest getTopicAttributesRequest) {
		return null;
	}

	@Override
	public GetTopicAttributesResult getTopicAttributes(String topicArn) {
		return null;
	}

	@Override
	public ListEndpointsByPlatformApplicationResult listEndpointsByPlatformApplication(
			ListEndpointsByPlatformApplicationRequest listEndpointsByPlatformApplicationRequest) {
		return null;
	}

	@Override
	public ListOriginationNumbersResult listOriginationNumbers(
			ListOriginationNumbersRequest listOriginationNumbersRequest) {
		return null;
	}

	@Override
	public ListPhoneNumbersOptedOutResult listPhoneNumbersOptedOut(
			ListPhoneNumbersOptedOutRequest listPhoneNumbersOptedOutRequest) {
		return null;
	}

	@Override
	public ListPlatformApplicationsResult listPlatformApplications(
			ListPlatformApplicationsRequest listPlatformApplicationsRequest) {
		return null;
	}

	@Override
	public ListPlatformApplicationsResult listPlatformApplications() {
		return null;
	}

	@Override
	public ListSMSSandboxPhoneNumbersResult listSMSSandboxPhoneNumbers(
			ListSMSSandboxPhoneNumbersRequest listSMSSandboxPhoneNumbersRequest) {
		return null;
	}

	@Override
	public ListSubscriptionsResult listSubscriptions(ListSubscriptionsRequest listSubscriptionsRequest) {
		return null;
	}

	@Override
	public ListSubscriptionsResult listSubscriptions() {
		return null;
	}

	@Override
	public ListSubscriptionsResult listSubscriptions(String nextToken) {
		return null;
	}

	@Override
	public ListSubscriptionsByTopicResult listSubscriptionsByTopic(
			ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) {
		return null;
	}

	@Override
	public ListSubscriptionsByTopicResult listSubscriptionsByTopic(String topicArn) {
		return null;
	}

	@Override
	public ListSubscriptionsByTopicResult listSubscriptionsByTopic(String topicArn, String nextToken) {
		return null;
	}

	@Override
	public ListTagsForResourceResult listTagsForResource(ListTagsForResourceRequest listTagsForResourceRequest) {
		return null;
	}

	@Override
	public ListTopicsResult listTopics(ListTopicsRequest listTopicsRequest) {
		return null;
	}

	@Override
	public ListTopicsResult listTopics() {
		return null;
	}

	@Override
	public ListTopicsResult listTopics(String nextToken) {
		return null;
	}

	@Override
	public OptInPhoneNumberResult optInPhoneNumber(OptInPhoneNumberRequest optInPhoneNumberRequest) {
		return null;
	}

	@Override
	public PublishResult publish(String topicArn, String message) {
		return null;
	}

	@Override
	public PublishResult publish(String topicArn, String message, String subject) {
		return null;
	}

	@Override
	public PublishBatchResult publishBatch(PublishBatchRequest publishBatchRequest) {
		return null;
	}

	@Override
	public PutDataProtectionPolicyResult putDataProtectionPolicy(
			PutDataProtectionPolicyRequest putDataProtectionPolicyRequest) {
		return null;
	}

	@Override
	public RemovePermissionResult removePermission(RemovePermissionRequest removePermissionRequest) {
		return null;
	}

	@Override
	public RemovePermissionResult removePermission(String topicArn, String label) {
		return null;
	}

	@Override
	public SetEndpointAttributesResult setEndpointAttributes(
			SetEndpointAttributesRequest setEndpointAttributesRequest) {
		return null;
	}

	@Override
	public SetPlatformApplicationAttributesResult setPlatformApplicationAttributes(
			SetPlatformApplicationAttributesRequest setPlatformApplicationAttributesRequest) {
		return null;
	}

	@Override
	public SetSMSAttributesResult setSMSAttributes(SetSMSAttributesRequest setSMSAttributesRequest) {
		return null;
	}

	@Override
	public SetSubscriptionAttributesResult setSubscriptionAttributes(
			SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) {
		return null;
	}

	@Override
	public SetSubscriptionAttributesResult setSubscriptionAttributes(String subscriptionArn, String attributeName,
			String attributeValue) {
		return null;
	}

	@Override
	public SetTopicAttributesResult setTopicAttributes(SetTopicAttributesRequest setTopicAttributesRequest) {
		return null;
	}

	@Override
	public SetTopicAttributesResult setTopicAttributes(String topicArn, String attributeName, String attributeValue) {
		return null;
	}

	@Override
	public SubscribeResult subscribe(SubscribeRequest subscribeRequest) {
		return null;
	}

	@Override
	public SubscribeResult subscribe(String topicArn, String protocol, String endpoint) {
		return null;
	}

	@Override
	public TagResourceResult tagResource(TagResourceRequest tagResourceRequest) {
		return null;
	}

	@Override
	public UnsubscribeResult unsubscribe(UnsubscribeRequest unsubscribeRequest) {
		return null;
	}

	@Override
	public UnsubscribeResult unsubscribe(String subscriptionArn) {
		return null;
	}

	@Override
	public UntagResourceResult untagResource(UntagResourceRequest untagResourceRequest) {
		return null;
	}

	@Override
	public VerifySMSSandboxPhoneNumberResult verifySMSSandboxPhoneNumber(
			VerifySMSSandboxPhoneNumberRequest verifySMSSandboxPhoneNumberRequest) {
		return null;
	}

	@Override
	public void shutdown() {

	}

	@Override
	public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
		return null;
	}

}

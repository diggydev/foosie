package com.jakubstas.integration.util;

import org.mockserver.model.HttpRequest;
import org.springframework.beans.factory.annotation.Value;

import static org.mockserver.model.HttpRequest.request;

public final class RequestUtils {

    @Value("${slack.incoming-web-hook-path}")
    private String incomingWebHookPath;

    public final HttpRequest getInternalErrorPrivateMessageBodyRequest() {
        return request().withBody("POST").withBody("/").withBody(SlackMessageBodies.createInternalErrorPrivateMessageBody());
    }

    public final HttpRequest getGamesCommandWithNoActiveGameRequest() {
        return request().withMethod("POST").withPath("/").withBody(SlackMessageBodies.createNoActiveGamesPrivateMessageBody());
    }

    public final HttpRequest getGamesCommandWithOneActiveGameRequest(final String hostName, final String scheduledTime, final int numberOfPlayers) {
        return request().withMethod("POST").withPath("/").withBody(SlackMessageBodies.createOneActiveGamePrivateMessageBody(hostName, scheduledTime, numberOfPlayers));
    }

    public final HttpRequest getNewGameInviteChannelMessageRequest(final String hostName, final String proposedTime) {
        return request().withMethod("POST").withPath(incomingWebHookPath).withBody(SlackMessageBodies.createGameInviteChannelMessageBody(hostName, proposedTime));
    }

    public final HttpRequest getNewGameInvitePrivateMessageRequest(final String proposedTime) {
        return request().withMethod("POST").withPath("/").withBody(SlackMessageBodies.createGameInvitePrivateMessageBody(proposedTime));
    }

    public final HttpRequest getNewGameLobyHasBeenCreatedPrivateMessageRequest(final String hostName, final String proposedTime) {
        return request().withMethod("POST").withPath("/").withBody(SlackMessageBodies.createGameLobbyHasBeenCreatedPrivateMessageBody(hostName, proposedTime));
    }

    public final HttpRequest getGameInvitePrivateMessageRequest(final String proposedTime) {
        return request().withMethod("POST").withPath("/").withBody(SlackMessageBodies.createGameInvitePrivateMessageBody(proposedTime));
    }

    public final HttpRequest getNewGameLobbyHasBeenCreatedPrivateMessageRequest(final String hostName, final String proposedTime) {
        return request().withMethod("POST").withPath("/").withBody(SlackMessageBodies.createGameLobbyHasBeenCreatedPrivateMessageBody(hostName, proposedTime));
    }

    public final HttpRequest getConfirmationAboutJoiningNewGamePrivateMessageRequest(final String hostName, final String proposedTime) {
        return request().withMethod("POST").withPath("/").withBody(SlackMessageBodies.createConfirmationAboutJoiningGamePrivateMessageBody(hostName, proposedTime));
    }

    public final HttpRequest getNotificationThatNewPlayerJoinedGamePrivateMessageRequest(final String userName) {
        return request().withMethod("POST").withPath("/").withBody(SlackMessageBodies.createNewPlayerJoinedGameNotificationPrivateMessageBody(userName));
    }

    public final HttpRequest getGameInviteAlreadyPostedPrivateMessageRequest() {
        return request().withMethod("POST").withPath("/").withBody(SlackMessageBodies.createGameInviteAlreadyPostedPrivateMessageBody());
    }
}

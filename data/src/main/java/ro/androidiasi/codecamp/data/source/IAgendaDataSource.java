package ro.androidiasi.codecamp.data.source;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataSponsor;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;

/**
 * Created by andrei on 06/04/16.
 */
public interface IAgendaDataSource<Id> {

    void getRoomsList(boolean pForced, ILoadCallback<List<DataRoom>> pLoadCallback);
    void getSessionsList(boolean pForced, ILoadCallback<List<DataSession>> pLoadCallback);
    void getFavoriteSessionsList(boolean pFroced, ILoadCallback<List<DataSession>> pLoadCallback);
    void getTimeFramesList(boolean pForced, ILoadCallback<List<DataTimeFrame>> pLoadCallback);
    void getCodecampersList(boolean pForced, ILoadCallback<List<DataCodecamper>> pLoadCallback);
    void getSponsorsList(boolean pForced, ILoadCallback<List<DataSponsor>> pLoadCallback);

    void getRoomsList(ILoadCallback<List<DataRoom>> pLoadCallback);
    void getSessionsList(ILoadCallback<List<DataSession>> pLoadCallback);
    void getFavoriteSessionsList(ILoadCallback<List<DataSession>> pLoadCallback);
    void getTimeFramesList(ILoadCallback<List<DataTimeFrame>> pLoadCallback);
    void getCodecampersList(ILoadCallback<List<DataCodecamper>> pLoadCallback);
    void getSponsorsList(ILoadCallback<List<DataSponsor>> pLoadCallback);

    void getRoom(Id pId, ILoadCallback<DataRoom> pLoadCallback);
    void getSession(Id pId, ILoadCallback<DataSession> pLoadCallback);
    void getTimeFrame(Id pId, ILoadCallback<DataTimeFrame> pLoadCallback);
    void getCodecamper(Id pId, ILoadCallback<DataCodecamper> pLoadCallback);

    void isSessionFavorite(Id pId, ILoadCallback<Boolean> pLoadCallback);
    void setSessionFavorite(Id pId, boolean pFavorite, ILoadCallback<Boolean> pLoadCallback);

    void setConference(DataConference pConference);
    DataConference getConference();
    void invalidate();
}

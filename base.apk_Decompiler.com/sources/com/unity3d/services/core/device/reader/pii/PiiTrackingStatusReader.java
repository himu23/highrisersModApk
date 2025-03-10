package com.unity3d.services.core.device.reader.pii;

import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.unity3d.services.core.misc.IJsonStorageReader;

public class PiiTrackingStatusReader {
    private final IJsonStorageReader _jsonStorageReader;
    private final NonBehavioralFlagReader _nonBehavioralFlagReader;

    public PiiTrackingStatusReader(IJsonStorageReader iJsonStorageReader) {
        this._jsonStorageReader = iJsonStorageReader;
        this._nonBehavioralFlagReader = new NonBehavioralFlagReader(iJsonStorageReader);
    }

    public PiiPrivacyMode getPrivacyMode() {
        if (getUserPrivacyMode() == PiiPrivacyMode.NULL && getSpmPrivacyMode() == PiiPrivacyMode.NULL) {
            return PiiPrivacyMode.NULL;
        }
        if (getUserPrivacyMode() == PiiPrivacyMode.APP || getSpmPrivacyMode() == PiiPrivacyMode.APP) {
            return PiiPrivacyMode.APP;
        }
        if (getUserPrivacyMode() == PiiPrivacyMode.MIXED || getSpmPrivacyMode() == PiiPrivacyMode.MIXED) {
            return PiiPrivacyMode.MIXED;
        }
        if (getUserPrivacyMode() == PiiPrivacyMode.NONE || getSpmPrivacyMode() == PiiPrivacyMode.NONE) {
            return PiiPrivacyMode.NONE;
        }
        return PiiPrivacyMode.UNDEFINED;
    }

    public boolean getUserNonBehavioralFlag() {
        return this._nonBehavioralFlagReader.getUserNonBehavioralFlag() == NonBehavioralFlag.TRUE;
    }

    private PiiPrivacyMode getUserPrivacyMode() {
        return getPrivacyMode(JsonStorageKeyNames.PRIVACY_MODE_KEY);
    }

    private PiiPrivacyMode getSpmPrivacyMode() {
        return getPrivacyMode(JsonStorageKeyNames.PRIVACY_SPM_KEY);
    }

    private PiiPrivacyMode getPrivacyMode(String str) {
        String str2;
        IJsonStorageReader iJsonStorageReader = this._jsonStorageReader;
        if (iJsonStorageReader != null) {
            Object obj = iJsonStorageReader.get(str);
            if (obj instanceof String) {
                str2 = (String) obj;
                return PiiPrivacyMode.getPiiPrivacyMode(str2);
            }
        }
        str2 = null;
        return PiiPrivacyMode.getPiiPrivacyMode(str2);
    }
}

package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

final class AutoValue_BackendResponse extends BackendResponse {
    private final long nextRequestWaitMillis;
    private final BackendResponse.Status status;

    public long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public BackendResponse.Status getStatus() {
        return this.status;
    }

    AutoValue_BackendResponse(BackendResponse.Status status2, long j) {
        if (status2 != null) {
            this.status = status2;
            this.nextRequestWaitMillis = j;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public String toString() {
        return "BackendResponse{status=" + this.status + ", nextRequestWaitMillis=" + this.nextRequestWaitMillis + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        if (!this.status.equals(backendResponse.getStatus()) || this.nextRequestWaitMillis != backendResponse.getNextRequestWaitMillis()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.nextRequestWaitMillis;
        return ((this.status.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }
}

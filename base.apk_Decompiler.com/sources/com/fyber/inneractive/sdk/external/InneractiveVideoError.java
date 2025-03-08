package com.fyber.inneractive.sdk.external;

public class InneractiveVideoError extends InneractiveError {
    public final Error a;
    public Throwable b;

    public enum Error {
        ERROR_NO_MEDIA_FILES("ErrorNoMediaFiles", true),
        ERROR_FAILED_PLAYING_MEDIA_FILE("ErrorPlayingMediaFile", false),
        ERROR_FAILED_PLAYING_ALL_MEDIA_FILES("ErrorPlayingAllMediaFile", true),
        ERROR_PRE_BUFFER_TIMEOUT("ErrorPreBufferTimeout", false),
        ERROR_BUFFER_TIMEOUT("ErrorBufferTimeout", false);
        
        private String errorString;
        private boolean isFatal;

        /* access modifiers changed from: public */
        Error(String str, boolean z) {
            this.errorString = str;
            this.isFatal = z;
        }

        public String getErrorString() {
            return this.errorString;
        }

        public boolean isFatal() {
            return this.isFatal;
        }
    }

    public InneractiveVideoError(Error error) {
        this.a = error;
    }

    public Throwable getCause() {
        return this.b;
    }

    public Error getPlayerError() {
        return this.a;
    }

    public String description() {
        if (this.b == null) {
            return this.a.getErrorString();
        }
        return this.a.getErrorString() + ": " + this.b;
    }

    public InneractiveVideoError(Error error, Throwable th) {
        this(error);
        this.b = th;
    }
}

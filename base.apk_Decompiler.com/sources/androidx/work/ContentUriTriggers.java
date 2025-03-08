package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class ContentUriTriggers {
    private final Set<Trigger> mTriggers = new HashSet();

    public Set<Trigger> getTriggers() {
        return this.mTriggers;
    }

    public void add(Uri uri, boolean z) {
        this.mTriggers.add(new Trigger(uri, z));
    }

    public int size() {
        return this.mTriggers.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mTriggers.equals(((ContentUriTriggers) obj).mTriggers);
    }

    public int hashCode() {
        return this.mTriggers.hashCode();
    }

    public static final class Trigger {
        private final boolean mTriggerForDescendants;
        private final Uri mUri;

        public Uri getUri() {
            return this.mUri;
        }

        public boolean shouldTriggerForDescendants() {
            return this.mTriggerForDescendants;
        }

        Trigger(Uri uri, boolean z) {
            this.mUri = uri;
            this.mTriggerForDescendants = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Trigger trigger = (Trigger) obj;
            if (this.mTriggerForDescendants != trigger.mTriggerForDescendants || !this.mUri.equals(trigger.mUri)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.mUri.hashCode() * 31) + (this.mTriggerForDescendants ? 1 : 0);
        }
    }
}

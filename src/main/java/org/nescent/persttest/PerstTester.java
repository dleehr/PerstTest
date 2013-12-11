package org.nescent.persttest;
import org.garret.perst.*;

/**
 *
 * @author Dan Leehr (dan.leehr@nescent.org)
 */
public class PerstTester {
        Storage storage;
        public PerstTester() {
        SimplePersistent rootObject = new SimplePersistent();
        StorageFactory sf = StorageFactory.getInstance();
        this.storage = sf.createStorage();
        this.storage.setProperty("perst.multiclient.support", Boolean.TRUE);
        this.storage.setProperty("perst.lock.file", Boolean.TRUE);
        this.storage.open("/tmp/perstTester.db", Storage.DEFAULT_PAGE_POOL_SIZE);
	this.storage.beginThreadTransaction(Storage.READ_WRITE_TRANSACTION);
        this.storage.setRoot(rootObject);
        this.storage.endThreadTransaction();
    }
    public void testReadNoCatch(boolean fail) {
        this.storage.beginThreadTransaction(Storage.READ_ONLY_TRANSACTION);
        SimplePersistent rootObject = (SimplePersistent) this.storage.getRoot();
        rootObject.SimpleOperation(fail);
        this.storage.endThreadTransaction();
        System.out.println("testReadNoCatch finished");
    }

    public void testReadWriteNoCatch(boolean fail) {
        this.storage.beginThreadTransaction(Storage.READ_WRITE_TRANSACTION);
        SimplePersistent rootObject = (SimplePersistent) this.storage.getRoot();
        rootObject.SimpleOperation(fail);
        this.storage.endThreadTransaction();
        System.out.println("testReadWriteNoCatch finished");
    }

    public void testReadCatch(boolean fail) {
        try {
            this.storage.beginThreadTransaction(Storage.READ_ONLY_TRANSACTION);
            SimplePersistent rootObject = (SimplePersistent) this.storage.getRoot();
            rootObject.SimpleOperation(fail);
        } catch (Exception ex) {
            System.err.println("Execption caught in testReadCatch");
            ex.printStackTrace(System.err);
        } finally {
            this.storage.endThreadTransaction();
        }
        System.out.println("testReadCatch finished");
}

    public void testWriteCatch(boolean fail) {
        try {
            this.storage.beginThreadTransaction(Storage.READ_WRITE_TRANSACTION);
            SimplePersistent rootObject = (SimplePersistent) this.storage.getRoot();
            rootObject.SimpleOperation(fail);
        } catch (Exception ex) {
            System.err.println("Execption caught in testWriteCatch");
            ex.printStackTrace(System.err);
        } finally {
            this.storage.endThreadTransaction();
        }
        System.out.println("testReadWriteCatch finished");

    }
}

package snail.contact.sync.sms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.Telephony;
import snail.contact.provider.SnailTelephony;
import snail.contact.thread.SnailAsyncTask;

/**
 * Created by fenghb on 3/12/14.
 */
public class TelephonyBackUpTask extends SnailAsyncTask {

    private Context context;

    /**
     * construct method
     *
     * @param context
     */
    public TelephonyBackUpTask(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public Object doTask(Object inputParameters) {
        /**
         * backup sms
         */
        backupSms();


        return null;
    }

    public void backupSms() {

        Cursor cursor = context.getContentResolver().query(Telephony.Sms.CONTENT_URI, null, null, null, null);
        ContentValues contentValues = new ContentValues();
        ContentValues[] array = new ContentValues[]{};
        while (cursor.moveToNext()) {
            contentValues.put(Telephony.Sms._ID, cursor.getInt(cursor.getColumnIndex(Telephony.Sms._ID)));
            contentValues.put(Telephony.Sms.THREAD_ID, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.THREAD_ID)));
            contentValues.put(Telephony.Sms.ADDRESS, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.ADDRESS)));
            contentValues.put(Telephony.Sms.PERSON, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.PERSON)));
            contentValues.put(Telephony.Sms.DATE, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.DATE)));
            contentValues.put(Telephony.Sms.DATE_SENT, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.DATE_SENT)));
            contentValues.put(Telephony.Sms.PROTOCOL, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.PROTOCOL)));
            contentValues.put(Telephony.Sms.READ, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.READ)));
            contentValues.put(Telephony.Sms.STATUS, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.STATUS)));
            contentValues.put(Telephony.Sms.TYPE, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.TYPE)));
            contentValues.put(Telephony.Sms.REPLY_PATH_PRESENT, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.REPLY_PATH_PRESENT)));
            contentValues.put(Telephony.Sms.SUBJECT, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.SUBJECT)));
            contentValues.put(Telephony.Sms.BODY, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.BODY)));
            contentValues.put(Telephony.Sms.SERVICE_CENTER, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.SERVICE_CENTER)));
            contentValues.put(Telephony.Sms.LOCKED, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.LOCKED)));
            contentValues.put(Telephony.Sms.ERROR_CODE, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.ERROR_CODE)));
            contentValues.put(Telephony.Sms.SEEN, cursor.getInt(cursor.getColumnIndex(Telephony.Sms.SEEN)));
            array[cursor.getPosition()] = contentValues;
        }
        cursor.close();
        context.getContentResolver().bulkInsert(SnailTelephony.Sms.CONTENT_URI, array);
    }

}

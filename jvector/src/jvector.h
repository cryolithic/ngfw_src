/*
 * $HeadURL:$
 * Copyright (c) 2003-2007 Untangle, Inc. 
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License, version 2,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but
 * AS-IS and WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, TITLE, or
 * NONINFRINGEMENT.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 */

#ifndef _JVECTOR_H_
#define _JVECTOR_H_

#include <jni.h>

#include <mvutil/mvpoll.h>
#include <vector/sink.h>
#include <vector/source.h>
#include <vector/event.h>

#define JV_EVENT_TYPE   ( 0xA34 & EVENT_TYPE_MASK )

#define JV_KEY_TYPE     0x4321
#define JV_UDP_KEY_TYPE 0x4322

typedef struct jvector_sink {
    sink_t snk;
    jobject this;
    mvpoll_key_t* key;
    struct {
        jmethodID send_event;
        jmethodID shutdown;
        jmethodID raze;
    } mid;
} jvector_sink_t;

typedef struct jvector_source {
    source_t src;
    jobject this;
    mvpoll_key_t* key;
    
    struct {
        jmethodID get_event;
        jmethodID shutdown;
        jmethodID raze;
    } mid;
} jvector_source_t;

typedef struct jvector_event {
    event_t ev;
    jobject obj;
} jvector_event_t;

int               jvector_load                ( JNIEnv* env );

jvector_sink_t*   jvector_sink_malloc         ( void );
int               jvector_sink_init           ( jvector_sink_t* snk, jobject this, mvpoll_key_t* key );
jvector_sink_t*   jvector_sink_create         ( jobject this, mvpoll_key_t* key );

jvector_source_t* jvector_source_malloc       ( void );
int               jvector_source_init         ( jvector_source_t* snk, jobject this, mvpoll_key_t* key );
jvector_source_t* jvector_source_create       ( jobject this, mvpoll_key_t* key );

jvector_event_t*  jvector_event_malloc        ( void );
int               jvector_event_init          ( jvector_event_t* snk );
jvector_event_t*  jvector_event_create        ( void );

mvpoll_key_t*     socket_queue_key_malloc     ( void );
int               socket_queue_key_init       ( mvpoll_key_t* key, jobject this );
mvpoll_key_t*     socket_queue_key_create     ( jobject this );

#endif
